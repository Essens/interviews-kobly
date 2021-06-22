import express from "express";

const app = express();
const port = 3000;

const healthcheck = (req, res) => {
  res.sendStatus(200)
};


// IMPLEMENTATION

function shorten(req, res) {
  // implement
  res.status(200).send({url: ""})
};


const findUrl = (req, res) => {
  // implement
  res.status(200).send({url: ""})
};


app.get('/', (req, res) => res.send({"message": "hello, world"}));
app.get('/healthcheck', healthcheck);
app.get('/shorten', shorten);
app.get('/findurl', findUrl);

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
});

export default app
