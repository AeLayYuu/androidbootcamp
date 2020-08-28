import 'package:flutter/material.dart';
import 'package:flutter_provider/counter.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      initialRoute: '/',
      routes: {
        '/' : (context) => MyHomePage(),
        '/second': (context) => NextPage()

      },
      home: ChangeNotifierProvider<Counter>(create: (context) => Counter(),
      child: MyHomePage(),),
    );
  }
}

// class MyHomePage extends StatefulWidget {
//   @override
//   _MyHomePageState createState() => _MyHomePageState();
// }

// class _MyHomePageState extends State<MyHomePage> {
//   int count = 0;
//   void counter() {
//     setState(() {
//       count++;
//     });
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: Text("Provider"),
//       ),
//       body: Center(
//         child: Column(
//           children: [
//             Text("$count"),
//             RaisedButton(onPressed: counter, child: Text("Count"))
//           ],
//         ),
//       ),
//     );
//   }
// }
class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final counter = Provider.of<Counter>(context);
    return Scaffold(
      appBar: AppBar(title: Text("Provider"),
      ),
      body: Center(child: Column(children: [
        Text('${counter.getCounter()}',
        style: TextStyle(fontSize: 100,color: Colors.blue),),
        RaisedButton(onPressed: counter.increment,
        child: Text("count"),)
      ],),),
    );
  }
}

class NextPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Next Page"),
      ),
      body: Center(child: Column(children: [
        Text('${counter.getCounter()}',
        style: TextStyle(fontSize: 100,color: Colors.blue),),
        RaisedButton(onPressed: (){
          Navigator.pushNamed(context, routeName)
        },
        child: Text("Next"),)
      ],),),
      
    );
  }
}