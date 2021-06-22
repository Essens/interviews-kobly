import request from "supertest";
import assert from "assert";
import app from '../index.js'

describe('GET /shorten', () => {
  const agent = request.agent(app);
  const longUrl = 'http://www.this.is.a.long.url.com';
  let first = '';

  it('returns a shorter url', () => {
        return agent
        .get('/shorten?url='+longUrl)
        .expect(response => {
          first = response.body.url;
          assert(
              response.body.url.length < longUrl.length)
        })
      }
  );

  it('returns different shortened links for the same url', () => {
    return agent
    .get('/shorten?url='+longUrl)
    .expect(response => {
      console.log('response.body.url', response.body.url, 'first', first);
      assert(response.body.url !== first)
    })
  })
});

describe('GET /findurl', () => {
  const agent = request.agent(app);
  const longUrl = 'http://www.this.is.a.long.url.com';
  let resp = '';

  it('returns a shorter url', () => {
    return agent
    .get('/shorten?url=' + longUrl)
    .expect(response => {
      resp = response.body.url;
      assert(response.body.url.length < longUrl.length)
    });
  });

  it('returns the original url', () => {
        return agent
        .get('/findurl?url=' + resp)
        .expect(response => {
          assert.deepStrictEqual(response.body.url, longUrl)
        })
      }
  );
});

describe('GET /', () => {
  it('returns hello, world', () => {
        return request(app)
        .get('/')
        .expect(response => {
          assert.deepStrictEqual(response.body.message, "hello, world")
        })
      }
  )
});
