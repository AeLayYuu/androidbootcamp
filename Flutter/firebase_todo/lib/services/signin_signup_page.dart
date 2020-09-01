import 'package:firebase_todo/services/authentication.dart';
import 'package:flutter/material.dart';

class SignInSignUpPage extends StatefulWidget {
  final BaseAuth auth;
  final VoidCallback singninCallback;

  const SignInSignUpPage({Key key, this.auth, this.singninCallback})
      : super(key: key);

  @override
  _SignInSignUpPageState createState() => _SignInSignUpPageState();
}

class _SignInSignUpPageState extends State<SignInSignUpPage> {
  final formKey = GlobalKey<FormState>();

  bool _isLoading;
  bool _isSignInForm;

  String _email;
  String _password;
  String _errorMessage;

  bool validateAndSave() {
    final form = formKey.currentState;
    if (form.validate()) {
      form.save();
      return true;
    }
    return false;
  }

  void validateAndSubmit() async {
    setState(() {
      _errorMessage = "";
      _isLoading = true;
    });
    if (validateAndSave()) {
      String userId = "";
      try {
        if (_isSignInForm) {
          userId = await widget.auth.signIn(_email, _password);
        } else {
          userId = await widget.auth.signUp(_email, _password);
        }
        setState(() {
          _isLoading = false;
        });

        if (userId.length > 0 && userId != null && _isSignInForm == true) {
          widget.singninCallback();
        }
      } catch (e) {
        setState(() {
          _isLoading = false;
          _errorMessage = e.message;
          formKey.currentState.reset();
        });
      }
    }
  }

  @override
  void initState() {
    super.initState();
    _errorMessage = "";
    _isLoading = false;
    _isSignInForm = true;
  }

  void resetForm() {
    formKey.currentState.reset();
    _errorMessage = "";
  }

  void toggleForm() {
    resetForm();
    setState(() {
      _isSignInForm = !_isSignInForm;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: Text("Flutter ToDo"),
      ),
      body: Stack(
        children: [showCircularProgress(),
        showForm()
        ],
      ),
    );
  }

  Widget showForm() {
    return Container(
      padding: EdgeInsets.all(16),
      child: Form(
        key: formKey,
          child: ListView(
        children: [
          showEmailInput(),
          showPasswordInput(),
          showPrimaryButton(),
          showSecondaryButton(),
          showErrorMessage()
        ],
      )),
    );
  }

  Widget showCircularProgress() {
    if (_isLoading) {
      return Center(
        child: CircularProgressIndicator(),
      );
    }
    return Container(
      width: 0,
      height: 0,
    );
  }

  Widget showErrorMessage() {
    if (_errorMessage.length > 0 && _errorMessage != null)
      return Text(
        _errorMessage,
        style: TextStyle(color: Colors.red, fontSize: 12),
      );
    else {
      return Container(height: 0);
    }
  }

  Widget showEmailInput() {
    return Padding(
      padding: EdgeInsets.only(top: 100),
      child: TextFormField(
        maxLines: 1,
        keyboardType: TextInputType.emailAddress,
        autofocus: true,
        decoration: InputDecoration(
            hintText: 'Email',
            icon: Icon(
              Icons.mail,
              color: Colors.grey,
            )),
        validator: (value) => value.isEmpty ? 'Email can\'t be empty' : null,
        onSaved: (value) => _email = value.trim(),
      ),
    );
  }

  Widget showPasswordInput() {
    return Padding(
      padding: EdgeInsets.only(top: 100),
      child: TextFormField(
        maxLines: 1,
        obscureText: true,
        autofocus: false,
        decoration: InputDecoration(
            hintText: 'Password',
            icon: Icon(
              Icons.lock,
              color: Colors.grey,
            )),
        validator: (value) => value.isEmpty ? 'Password can\'t be empty' : null,
        onSaved: (value) => _password = value.trim(),
      ),
    );
  }

  Widget showPrimaryButton() {
    return Padding(
      padding: EdgeInsets.only(top: 30),
      child: RaisedButton(
        onPressed: validateAndSubmit,
        elevation: 4.0,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(30),
        ),
        color: Colors.blue,
        child: Text(
          _isSignInForm ? 'Sign in' : 'Create account',
          style: TextStyle(fontSize: 20, color: Colors.white),
        ),
      ),
    );
  }

  Widget showSecondaryButton() {
    return FlatButton(
        onPressed: toggleForm,
        child: Text(
          _isSignInForm ? 'Create account' : 'Already created? Sign in',
          style: TextStyle(fontSize: 18),
        ));
  }
}
