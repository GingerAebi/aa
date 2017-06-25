var http=require('http');
var express=require('express');
var bodyParser=require('body-parser');
var mysql = require('./lib/mysqlSupporter');

var app=express();

app.set('port',process.env.PORT||1234);

app.use(bodyParser.json({ limit: '10mb' }));
app.use(bodyParser.urlencoded({ extended: false }));

app.get('/',function(req,res){
  console.log('test');
  res.json({'rspCode' : 200, 'rspMsg' : 'SUCCESS'});
});

app.post('/user/register', function(req, res) {
  var name = req.body.name;
  var id = req.body.id;
  var password = req.body.password;
  var lan = req.body.lan;

  console.log('name : ' + name + ', id : ' + id + ', password : ' + password + ', lan : ' + lan);

  var user = {
    name : name,
    id : id,
    password : password,
    lan : lan
  }

  mysql.registUser(user, function(err, result){
    if(err) {
      console.log(err);
      res.json({'rspCode' : 500, 'rspMsg' : 'DB INSERT FAIL - USER'});
    } else {
      res.json({'rspCode' : 200, 'rspMsg' : 'SUCESS', data : result});
    }
  });
});

app.use(function(req,res,next){
  res.status(404).send('Not Found...'+'('+req.originalUrl+')');
})

app.use(function(err,req,res){
  res.status(err.status||500);
  res.send('Err occured ...' + '('+req.originalUrl+')');
});

app.listen(app.get('port'));
