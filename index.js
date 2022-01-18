var client_id = 'CLIENT_ID';
var redirect_uri = 'http://localhost:8888/callback';

const express = require('express')

var app = express();
const port = 3000

app.get('/login', function(req, res) {

  //var state = generateRandomString(16);
  var scope = 'user-read-private user-read-email';

  var client_id = 'eb10f4bfc1da4ac49632ac79da23bf5b'

  res.redirect('https://accounts.spotify.com/authorize?' +
    querystring.stringify({
      response_type: 'code',
      client_id: client_id,
      scope: scope,
      redirect_uri: redirect_uri,
      //state: state
    }));
});

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
  })