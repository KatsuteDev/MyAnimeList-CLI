---
command: mal api <endpoint>
options:
  - flags: [-X, --method]
    type: string
    desc: The HTTP method for the request
  - flags: [-f, --field]
    desc: Fields to return
  - nsfw
  - jq
see-also:
  - mal
---
Makes an authenticated request to the MyAnimeList API and prints the response.