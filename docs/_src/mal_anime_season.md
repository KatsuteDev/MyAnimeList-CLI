---
command: mal anime season <year> <season>
options:
  - flags: [-s, --sort]
    type: string
    desc: |
      Sort order

      |value|
      |---|
      |`score`|
      |`users`|
  - limit
  - offset
  - csv
  - json
  - jq
  - web
see-also:
  - mal anime view
---
Search for seasonal Anime.

|season|months|
|--|---|
|`winter`|January, February, March|
|`spring`|April, May, June|
|`summer`|July, August, September|
|`fall`|October, November, December|