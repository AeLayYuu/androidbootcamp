import 'package:firebase_todo/services/authentication.dart';
import 'package:firebase_todo/services/signin_signup_page.dart';
import 'package:flutter/material.dart';

enum AuthStatus {
  Not_DeTERMINE,
  NOT_SIGN_IN,
  SIGN_IN,
}

class RootPage extends StatefulWidget {
  final BaseAuth auth;

  const RootPage({this.auth});
  @override
  _RootPageState createState() => _RootPageState();
}

class _RootPageState extends State<RootPage> {
  AuthStatus authStatus = AuthStatus.Not_DeTERMINE;

  String userId = "";

  @override
  void initState() {
    super.initState();
    widget.auth.getCurrentUser().then((user) {
      setState(() {
        if (user != null) {
          userId = user.uid;
        }

        authStatus =
            (user?.uid == null ? AuthStatus.NOT_SIGN_IN : AuthStatus.SIGN_IN);
      });
    });
  }

  void signinCallback() {
    widget.auth.getCurrentUser().then((value) {
      setState(() {
        userId = value.uid.toString();
        authStatus = AuthStatus.SIGN_IN;
      });
    });
  }

  void signOutCallback() {
    setState(() {
      authStatus = AuthStatus.NOT_SIGN_IN;
      userId = "";
    });
  }

  Widget waitingScreen() {
    return Scaffold(
      body: Center(
        child: CircularProgressIndicator(),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    switch (authStatus) {
      case AuthStatus.Not_DeTERMINE:
        return waitingScreen();
        break;
      case AuthStatus.NOT_SIGN_IN:
        return SignInSignUpPage(
            auth: widget.auth, singninCallback: signinCallback);
        break;
      case AuthStatus.SIGN_IN:
        break;

      default:
        return waitingScreen();
    }
  }
}
