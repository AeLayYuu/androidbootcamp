import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyStateApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    Widget buttonSection = Container(
      child: Row(
        children: [_buildColumn(Icons.call, "CALL", color)],
      ),
    );

    final List<String> entries = ['A', 'B', 'C'];

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Flutter"),
        ),
        // body: Row(children: [
        //   Column(
        //     children: [Icon(Icons.star), Text("12232")],
        //   ),
        //   Column(
        //     children: [Icon(Icons.star), Text("12232")],
        //   ),
        //   _buildColumn(Icons.star, "3234", Colors.pink),
        //   _buildColumn(Icons.file_download, "2433", Colors.red),
        //       buttonSection

        // ])),
        // body: ListView.builder(
        //   itemCount: entries.length,
        //   itemBuilder: (BuildContext context, int index) {
        //     return Container(
        //       height: 50,
        //       child: Center(
        //         child: Text("Entry ${entries[index]}"),
        //       )
        //     );
        //   },
        // )
        body: ListView.separated(
            itemBuilder: (BuildContext context, int index) {
              return Container(
                height: 50,
                child: Center(
                  child: Text("Entry ${entries[index]}"),
                ),
              );
            },
            separatorBuilder: (BuildContext context, int index) => Divider(),
            itemCount: entries.length),
      ),
    );
  }

  Color color = Colors.blue;

  Column _buildColumn(IconData iconData, String label, Color color) {
    return Column(
      children: [
        Icon(
          iconData,
          color: color,
        ),
        Text(
          label,
          style: TextStyle(color: color),
        )
      ],
    );
  }
}

class MyStateApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Stateful Widget"),
        ),
        body: _StatefulApp(),
      ),
    );
  }
}

class _StatefulApp extends StatefulWidget {
  @override
  _StatefulAppState createState() => _StatefulAppState();
}

class _StatefulAppState extends State<_StatefulApp> {
  int count = 0;

  var text = 0;

  final textName = TextEditingController();

  @override
  Widget build(BuildContext context) {
    void incrementCount() {
      setState(() {
        count++;
      });
    }

    void decrementCount() {
      setState(() {
        count--;
      });
    }

    return Container(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            "$count",
            style: TextStyle(fontSize: 50, color: Colors.blue),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              RaisedButton(
                  onPressed: decrementCount,
                  color: Colors.deepPurple,
                  child: Text("Decrement",
                      style: TextStyle(
                        fontSize: 15,
                      ))),
                      SizedBox(width: 25,),
              RaisedButton(
                  onPressed: incrementCount,
                  color: Colors.deepOrangeAccent,
                  child: Text("Increasement",
                      style: TextStyle(
                        fontSize: 15,
                      ))),
            ],
          ),
          TextField(
              controller: textName,
              keyboardType: TextInputType.number,
              inputFormatters: [
                FilteringTextInputFormatter.digitsOnly
              ],
              decoration: InputDecoration(
                  hintText: "Enter name", border: UnderlineInputBorder() )),
          RaisedButton(
              onPressed: () {
                setState(() {
                  text = int.parse(textName.text);
                });
              },
              child: Text("Submit")),
          Text("$text")
        ],
      ),
    );
  }
}
