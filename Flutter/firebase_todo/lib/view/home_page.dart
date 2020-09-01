import 'dart:async';

import 'package:firebase_database/firebase_database.dart';
import 'package:firebase_todo/model/todo.dart';
import 'package:firebase_todo/services/authentication.dart';
import 'package:flutter/cupertino.dart';

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
  List<ToDo> _todoList;

  Query _todoQuery;
  Query _todoQuery;

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
        _onTodoAddedSubscription = _todoQuery
        .onChildAdded.listen((onEntryAdded);
        _onTodoChangedSubscription = _todoQuery.onChildChanged.listen(onEntryChange);
  }

  onEntryChange(Event event) {
var oldEntry = _todoList.singleWhere((element) {
  return element.key == event.snapshot.key;
});

setState(() {
  _todoList[_todoList.indexOf(oldEntry)] == 
  ToDo.fromSnapShot(event.snapshot)
});
  }

  Widget build(BuildContext context) {
    return Container();
  }
}
