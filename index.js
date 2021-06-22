import express from "express";

const app = express();
const port = 3000;

const healthcheck = (req, res) => {
  res.sendStatus(200)
};

app.locals.database = {};
const urls = app.locals.database;

function shorten(req, res) {
  const url = req.query.url;
  const shorterUrl = "http://www."+Object.keys(urls).length+".com";

  urls[shorterUrl] = url;

  res.status(200).send({url: shorterUrl})
};


const findUrl = (req, res) => {
  const shortUrl = req.query.url;

  res.status(200).send({url: urls[shortUrl]})
};


app.get('/', (req, res) => res.send({"message": "hello, world"}));
app.get('/healthcheck', healthcheck);
app.get('/shorten', shorten);
app.get('/findurl', findUrl);

app.use((req, res, next) => {
  res.set('Cache-Control', 'no-store');
  next()
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
});

export default app
