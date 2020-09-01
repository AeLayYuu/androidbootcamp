import 'package:firebase_database/firebase_database.dart';

class ToDo {
  String key;
  String subject;
  bool completed;
  String userId;

  ToDo(this.subject, this.completed, this.userId);
  ToDo.fromSnapShot(DataSnapshot snapshot)
      : key = snapshot.key,
        userId = snapshot.value["userId"],
        subject = snapshot.value["subject"],
        completed = snapshot.value["completed"];

  toJson() {
    return {"userId": userId, "subject": subject, "completed": completed};
  }
}
