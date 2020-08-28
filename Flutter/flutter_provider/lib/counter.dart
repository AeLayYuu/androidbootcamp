import 'package:flutter/cupertino.dart';

class Counter extends ChangeNotifier {
  int _counter = 0;

  getCounter() => _counter;
  setCounter(int counter) => _counter = counter;

  void increment() {
    _counter++;
    notifyListeners();
  }
}
