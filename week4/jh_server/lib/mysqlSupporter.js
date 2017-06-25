var mysql = require('mysql');

var pool  = mysql.createPool({
  host: "localhost",
  user: "root",
  password: "study123",
  database: 'coin',
  connectionLimit: 60,
  waitForConnection: true
});

exports.registUser = function(user, next){
  pool.getConnection(function (err, connection) {
    if (err) {
      console.log('err:' + err);
      next(new Error('ERR.MYSQL.CONN'));
      return;
    }
    connection.query('INSERT INTO user(name, id, password, lan) VALUES(?, ?, ?, ?)', [user.name, user.id, user.password, user.lan], function (err, result) {
      if (err) {
        next(err);
      }
      else {
        next(null, result);
      }
    });
  });
};
