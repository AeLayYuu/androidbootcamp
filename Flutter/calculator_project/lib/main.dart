import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(CalculatorProject());
}

class CalculatorProject extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text("Calculator"),
        ),
        body: _CalculatorProject(),
      ),
    );
  }
}

class _CalculatorProject extends StatefulWidget {
  @override
  _CalculatorProjectState createState() => _CalculatorProjectState();
}

class _CalculatorProjectState extends State<_CalculatorProject> {
  var result = 0.0;

  TextEditingController one = TextEditingController();
  TextEditingController two = TextEditingController();

  @override
  Widget build(BuildContext context) {
    void addNumber() {
      setState(() {
        result = double.parse(one.text) + double.parse(two.text);
      });
    }

    void subNumber() {
      setState(() {
        result = double.parse(one.text) - double.parse(two.text);
      });
    }

    void multNumber() {
      setState(() {
        result = double.parse(one.text) * double.parse(two.text);
      });
    }

    void divdNumber() {
      setState(() {
        result = double.parse(one.text) / double.parse(two.text);
      });
    }

    return Container(
      child: Column(
        children: [
          TextField(
              controller: one,
              keyboardType: TextInputType.number,
              inputFormatters: [FilteringTextInputFormatter.digitsOnly],
              decoration: InputDecoration(
                  hintText: "Enter Number one",
                  border: UnderlineInputBorder())),
          TextField(
              controller: two,
              keyboardType: TextInputType.number,
              inputFormatters: [FilteringTextInputFormatter.digitsOnly],
              decoration: InputDecoration(
                  hintText: "Enter Number two",
                  border: UnderlineInputBorder())),
          RaisedButton(
            onPressed: addNumber,
            color: Colors.blueAccent,
            child: Text("ADD"),
          ),
          RaisedButton(
            onPressed: subNumber,
            color: Colors.blueAccent,
            child: Text("SUB"),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              RaisedButton(
                onPressed: multNumber,
                color: Colors.blueAccent,
                child: Text("MULTIPLY"),
              ),
              RaisedButton(
                onPressed: divdNumber,
                color: Colors.blueAccent,
                child: Text("DIVIDING"),
              )
            ],
          ),
          Text(
            "$result",
            style: TextStyle(fontSize: 50, color: Colors.blue),
          ),
        ],
      ),
    );
  }
}
