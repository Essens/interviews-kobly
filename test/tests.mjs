import request from "supertest";
import assert from "assert";
import app from '../index.js'

/**
 * NB: Tests assume both the /shorten and /findurl endpoints are GETs,
 * and expect the [to-be-shortened or shortened] url to be given as a query
 * parameter. The tests further assume the response from both endpoints is
 * on the format {url: <some-string>}
 *
 */


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
