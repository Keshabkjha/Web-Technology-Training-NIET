var express = require('express')
const path = require('path')
var app = express()
app.set('view engine', 'ejs');
app.use(express.static('public'))  //Middleware
 
// route that gets executed for GET request and the request url path '/' or root
app.get('/set-session', function(req, res) {
    req.session.username = "programming experience"
    res.send('session are set')
})
app.get('/get-session', function(req, res) {
    res.send('your name is : '+req.session.username)
})

var server
app.get('/', function (req, res) {
   res.send('Home 1.')
})

var server = app.listen(3000, function(){
    console.log('Listening on port 3000...')
})