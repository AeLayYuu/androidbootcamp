import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
      appBar: AppBar(
        title: Text("Hello Fultter"),
        backgroundColor: Colors.red,
        actions: [
          IconButton(
              icon: Icon(
                Icons.alarm,
                color: Colors.white,
              ),
              onPressed: null),
          IconButton
              icon: Icon(
                Icons.add_alert,
                color: Colors.white,
              ),
              onPressed: null)
        ],
      ),
      body: SingleChildScrollView(
          child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.end,
              children: [
            Text(
              "Hello World",
              style: TextStyle(
                  color: Colors.blueAccent,
                  fontSize: 50,
                  fontWeight: FontWeight.bold,
                  fontStyle: FontStyle.italic),
            ),
            TextWidget(),
            TextWidget1(),
            TextWidget2(),
            Image.network(
              "https://cdn.pixabay.com/photo/2015/06/08/15/02/pug-801826_960_720.jpg",
              width: 200,
              height: 200,
              fit: BoxFit.cover,
            ),
            Image.asset(
              'images/imageone.jpg',
              height: 200,
              fit: BoxFit.cover,
            ),
            Row(
              children: [
                ButtonWidget(),
                Flexible(
                  child: ButtonWidget(),
                  flex: 2,
                  fit: FlexFit.tight,
                ),
                Flexible(
                  child: ButtonWidget(),
                  flex: 1,
                  fit: FlexFit.tight,
                ),
              ],
            ),
            Row(
              children: [
                ButtonWidget(),
                Expanded(
                  child: ButtonWidget(),
                  flex: 2,
                ),
                Expanded(
                  child: ButtonWidget(),
                  flex: 3,
                ),
              ],
            ),
            Row(
              children: [
                ButtonWidget(),
                Spacer(
                  flex: 1,
                ),
                ButtonWidget(),
                Spacer(
                  flex: 2,
                ),
                ButtonWidget(),
              ],
            )
          ])),
    ));
  }
}

class ButtonWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return RaisedButton(
      onPressed: null,
      child: Text("One"),
    );
  }
}

class TextWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Text(
      "Hello World",
      style: TextStyle(
          color: Colors.blueAccent,
          fontSize: 50,
          fontWeight: FontWeight.bold,
          fontStyle: FontStyle.italic),
    );
  }
}

class TextWidget1 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Text(
      "Hello World",
      style: TextStyle(
          color: Colors.blueAccent,
          fontSize: 40,
          fontWeight: FontWeight.bold,
          fontStyle: FontStyle.italic),
    );
  }
}

class TextWidget2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Text(
      "Hello World",
      style: TextStyle(
          color: Colors.blueAccent,
          fontSize: 30,
          fontWeight: FontWeight.bold,
          fontStyle: FontStyle.italic),
    );
  }
}
