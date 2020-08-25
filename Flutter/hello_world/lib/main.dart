import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Hello Flutter"),
          backgroundColor: Colors.blue,
          actions: [
            // Icon(Icons.ac_unit),
            // Text("Share")
            IconButton(
                icon: Icon(
                  Icons.search,
                  color: Colors.white,
                ),
                onPressed: null),
            IconButton(
              icon: Icon(
                Icons.add,
                color: Colors.white,
              ),
              onPressed: null,
            )
          ],
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            TextWidgetOne(),
            TextWidgetTwo(),
            TextWidgetThree(),
            Row(
              children: [
                // ButtonWidget(),
                // Flexible(child: ButtonWidget(),
                // flex:1,
                // fit: FlexFit.tight,
                // ),
                // ButtonWidget(),
                // ButtonWidget()

                // Expanded(
                //   child: ButtonWidget(),
                //   flex: 2,
                // ),

                // Expanded(
                //   child: ButtonWidget(),
                //   flex: 3,
                // )
                ButtonWidget(),

                Spacer(flex: 1,),
                ButtonWidget(),

                Spacer(flex: 2,),
                ButtonWidget()
              ],
            )
          ],
        ),
      ),
    );
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

class TextWidgetOne extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Text(
      "Hello World !!!!",
      style: TextStyle(
          color: Colors.blueGrey,
          fontSize: 20,
          fontWeight: FontWeight.bold,
          fontStyle: FontStyle.italic),
    );
  }
}

class TextWidgetTwo extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Text(
      "Hello World !!!!",
      style: TextStyle(
          color: Colors.blueGrey,
          fontSize: 30,
          fontWeight: FontWeight.bold,
          fontStyle: FontStyle.italic),
    );
  }
}

class TextWidgetThree extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Text(
      "Hello World !!!!",
      style: TextStyle(
          color: Colors.blueGrey,
          fontSize: 40,
          fontWeight: FontWeight.bold,
          fontStyle: FontStyle.italic),
    );
  }
}
