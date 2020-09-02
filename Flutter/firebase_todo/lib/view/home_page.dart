import 'dart:async';
import 'package:firebase_database/firebase_database.dart';
import 'package:firebase_todo/model/todo.dart';
import 'package:firebase_todo/services/authentication.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  final BaseAuth auth;
  final VoidCallback signoutCallback;
  final String userId;

  const HomePage({Key key, this.auth, this.signoutCallback, this.userId})
      : super(key: key);
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<Todo> _todoList;

  Query _todoQuery;

  final _textEditingController = TextEditingController();

  StreamSubscription<Event> _onTodoAddedSubscription;
  StreamSubscription<Event> _onTodoChangedSubscription;

  final FirebaseDatabase _database = FirebaseDatabase.instance;

  @override
  void initState() {
    super.initState();
    _todoList = new List();
    _todoQuery = _database
        .reference()
        .child("todo")
        .orderByChild("userId")
        .equalTo(widget.userId);
    _onTodoAddedSubscription = _todoQuery.onChildAdded.listen(onEntryAdded);
    _onTodoChangedSubscription =
        _todoQuery.onChildChanged.listen(onEntryChange);
  }

  onEntryChange(Event event) {
    var oldEntry = _todoList.singleWhere((element) {
      return element.key == event.snapshot.key;
    });

    setState(() {
      _todoList[_todoList.indexOf(oldEntry)] =
          Todo.fromSnapShot(event.snapshot);
    });
  }

  @override
  void dispose() {
    super.dispose();
    _onTodoAddedSubscription.cancel();
    _onTodoChangedSubscription.cancel();
  }

  addNewTodo(String todoItem) {
    if (todoItem.length > 0) {
      Todo toDo = Todo(todoItem.toString(), false, widget.userId);
      _database.reference().child("todo").push().set(toDo.toJson());
    }
  }

  updateTodo(Todo todo) {
    todo.completed = !todo.completed;
    if (todo != null) {
      _database.reference().child("todo").child(todo.key).set(todo.toJson());
    }
  }

  deleteTodo(String todoId, int index) {
    _database.reference().child("todo").child(todoId).remove().then((_) {
      setState(() {
        _todoList.removeAt(index);
      });
    });
  }

  signOut() async {
    try {
      await widget.auth.singOut();
      widget.signoutCallback();
    } catch (e) {
      print(e);
    }
  }

  Widget showTodoList() {
    if (_todoList.length > 0) {
      return ListView.builder(
          itemCount: _todoList.length,
          itemBuilder: (BuildContext contextm, int index) {
            String todoId = _todoList[index].key;
            String subject = _todoList[index].subject;
            bool completed = _todoList[index].completed;
            String userId = _todoList[index].userId;

            return Dismissible(
                key: Key(todoId),
                background: Container(color: Colors.red),
                onDismissed: (direction) async {
                  deleteTodo(todoId, index);
                },
                child: ListTile(
                    title: Text(
                      subject,
                      style: TextStyle(fontSize: 20, color: Colors.blueAccent),
                    ),
                    trailing: IconButton(
                        onPressed: () {
                          updateTodo(_todoList[index]);
                        },
                        icon: (completed)
                            ? Icon(Icons.done_outline, color: Colors.green)
                            : Icon(Icons.done_outline,
                                color: Colors.grey, size: 20))));
          });
    } else {
      return Center(
          child: Text("Your List is Empty",
              textAlign: TextAlign.center, style: TextStyle(fontSize: 30)));
    }
  }

  onEntryAdded(Event event) {
    setState(() {
      _todoList.add(Todo.fromSnapShot(event.snapshot));
    });
  }

  showAddTodoDialog(BuildContext context) async {
    _textEditingController.clear();
    await showDialog<String>(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            content: Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: _textEditingController,
                    autofocus: true,
                    decoration: InputDecoration(hintText: "Add new toDo"),
                  ),
                )
              ],
            ),
            actions: [
              FlatButton(
                  onPressed: () {
                    Navigator.pop(context);
                  },
                  child: Text('Cancel')),
              FlatButton(
                  onPressed: () {
                    addNewTodo(_textEditingController.text.toString());
                    Navigator.pop(context);
                  },
                  child: Text('Save'))
            ],
          );
        });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("ToDo"),
        actions: [
          FlatButton(
            onPressed: signOut,
            child: Text(
              'SignOut',
              style: TextStyle(fontSize: 18, color: Colors.white),
            ),
          )
        ],
      ),
      body: showTodoList(),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          showAddTodoDialog(context);
        },
        child: Icon(Icons.add),
      ),
    );
  }
}
