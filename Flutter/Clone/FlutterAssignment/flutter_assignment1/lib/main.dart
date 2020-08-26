import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.green[900],
          actions: [
            IconButton(
                icon: Icon(
                  Icons.more_vert,
                  color: Colors.white,
                ),
                onPressed: null)
          ],
          leading: IconButton(
              icon: Icon(
                Icons.arrow_back,
                color: Colors.white,
              ),
              onPressed: null),
        ),
        body: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                crossAxisAlignment: CrossAxisAlignment.end,
                children: [
                  Column(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Text(
                        "John McDonald",
                        style: TextStyle(
                            fontSize: 25, fontWeight: FontWeight.bold),
                      ),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: [
                          Icon(Icons.location_on),
                          Text(
                            "Los Angles,CA",
                            style: TextStyle(fontSize: 20),
                          ),
                        ],
                      ),
                      SizedBox(
                        height: 40,
                      ),
                      RaisedButton(
                        onPressed: null,
                        child: Text(
                          "follow",
                          style: TextStyle(fontSize: 20),
                        ),
                        color: Colors.green[900],
                      ),
                      SizedBox(
                        height: 20,
                      ),
                      Row(
                        children: [
                          Column(
                            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "34",
                                style: TextStyle(fontSize: 20),
                              ),
                              Text(
                                "Posts",
                                style: TextStyle(fontSize: 15),
                              )
                            ],
                          ),
                          SizedBox(
                            width: 30,
                          ),
                          Column(
                            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                "1256",
                                style: TextStyle(fontSize: 20),
                              ),
                              Text(
                                "Followers",
                                style: TextStyle(fontSize: 15),
                              )
                            ],
                          ),
                        ],
                      )
                    ],
                  ),
                  Image.network(
                    "https://images.allhomes.com.au/agent/staff/bbae7daeef852b36e2874843f2031a9d_180x180.jpg",
                    width: 120,
                    height: 200,
                    fit: BoxFit.cover,
                  )
                ],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Image.asset(
                    "images/imageone.jpg",
                    width: 80,
                    height: 120,
                  ),
                  Image.asset(
                    "images/imagetwo.jpg",
                    width: 80,
                    height: 120,
                  ),
                  Image.asset(
                    "images/imagethree.jpg",
                    width: 80,
                    height: 120,
                  ),
                  Image.asset(
                    "images/imagefour.jpg",
                    width: 80,
                    height: 120,
                  ),
                ],
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Spacer(
                    flex: 1,
                  ),
                  Image.network(
                    "https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/14498067661530099611-64.png",
                    width: 25,
                    height: 30,
                  ),
                  Spacer(
                    flex: 1,
                  ),
                  Image.network(
                    "https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/5636191571582823586-64.png",
                    width: 25,
                    height: 30,
                  ),
                  Spacer(
                    flex: 1,
                  ),
                  Image.network(
                    "https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/13295027321554469048-64.png",
                    width: 25,
                    height: 30,
                  ),
                  Spacer(
                    flex: 1,
                  ),
                  Image.network(
                    "https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/20087062091556105709-64.png",
                    width: 25,
                    height: 30,
                  ),
                  Spacer(
                    flex: 1,
                  ),
                  Image.network(
                    "https://upload-icon.s3.us-east-2.amazonaws.com/uploads/icons/png/7086878461549345958-512.png",
                    width: 25,
                    height: 30,
                  ),
                  Spacer(
                    flex: 1,
                  ),
                ],
              ),
              SizedBox(height: 20),
              Text("About",
                  style: TextStyle(fontWeight: FontWeight.bold, fontSize: 22)),
              Text(
                "The area now called England was first inhabited by modern humans during the Upper Paleolithic period, but takes its name from the Angles, a Germanic tribe deriving its name from the Anglia peninsula, who settled during the 5th and 6th centuries. England became a unified state in the 10th century, and since the Age of Discovery, which began during the 15th century, has had a significant cultural and legal impact on the wider world.[10] The English language, the Anglican Church, and English law – the basis for the common law legal systems of many other countries around the world – developed in England, and the country's parliamentary system of government has been widely adopted by other nations.[11] The Industrial Revolution began in 18th-century England, transforming its society into the world's first industrialised nation.[12]",
                style: TextStyle(fontSize: 12),
              )
            ],
          ),
        ),
      ),
    );
  }
}
