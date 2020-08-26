import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {

     Widget buttonSection = Container(
    child: Row(
      children: [
        _buildColumn(
          Icons.call,
          "CALL", color
        )
      ],
    ),
  );
  

final List<String> entries =['A','B','C'];

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
          //   buttonSection
          // ])),
          body:ListView.builder(
            itemCount: entries.length,
            itemBuilder: (BuildContext context, int index) {
              return Container(
                height: 50,
                child: Center(child: Text("Entry ${entries[index]}")
                );
                }
          )
      ),
    )
    )
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

