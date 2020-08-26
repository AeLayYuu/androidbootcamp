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
          body: SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                TextWidgetOne(),
                TextWidgetTwo(),
                TextWidgetThree(),
                Image.network(
                  "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/spacex-founder-elon-musk-addresses-the-media-during-a-press-news-photo-1585058537.jpg?crop=1xw:0.74991xh;center,top&resize=980:*",
                  width: 250,
                  height: 250,
                  fit: BoxFit.cover,
                ),
                Image.asset(
                  'images/image.jpg',
                  width: 400,
                  height: 400,
                  fit: BoxFit.cover,
                ),
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

                    Spacer(
                      flex: 1,
                    ),
                    ButtonWidget(),

                    Spacer(
                      flex: 2,
                    ),
                    ButtonWidget()
                  ],
                )
              ],
            ),
          )),
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
