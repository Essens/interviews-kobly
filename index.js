// noinspection JSCheckFunctionSignatures
import express from "express";

const app = express();
const port = 3000;

const healthcheck = (req, res) => {
  res.sendStatus(200)
};

app.locals.database = {};

function shorten(req, res) {
  // Implement me

  res.status(200).send({url: ""})
};

const findUrl = (req, res) => {
  // Implement me

  res.status(200).send({url: ""})
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
