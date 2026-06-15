const express = require('express')
const colors = require('colors')
const path=require("path")
const app = express()
const port = 3000
app.set('view engine', 'ejs')
app.use(express.static('public'))



app.get('/', (req, res) => {
  res.send('Hello World!')
})

// app.get('/index', (req, res) => {
//   res.sendFile(path.join(__dirname,'index.html'))
// })
// app.get('/about', (req, res) => {
//   res.sendFile(path.join(__dirname,'about.html'))
// })
// app.get('/contact', (req, res) => {
//   res.sendFile(path.join(__dirname,'contact.html'))
// })
app.get('/services', (req, res) => {
  res.sendFile(path.join(__dirname,'services.html'))
})


// app.listen(port, () => {
//   console.log(`Example app listening on port ${port}`.bgMagenta)
// })

app.get('/download', function (req, res) {
  res.download(path.join(__dirname, 'about.html'))
})

var server = app.listen(3000, function() {
  console.log("Listening on port 3000...")
})
