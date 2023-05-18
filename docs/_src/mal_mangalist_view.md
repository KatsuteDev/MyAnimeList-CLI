---
command: mal mangalist view <id>
options:
  - user
  - flags: [-S, --status]
    type: string
    desc: |
      Status to filter

      |status|
      |---|
      |`reading`|
      |`completed`|
      |`on_hold`|
      |`dropped`|
      |`planned_to_read`|
  - flags: [-s, --sort]
    type: string
    desc: |
      Sort order

      |value|
      |---|
      |`score`|
      |`updated_at`|
      |`title`|
      |`start`|
  - limit
  - offset
  - nsfw
  - csv
  - json
  - jq
  - web
see-also:
  - mal mangalist update
  - mal mangalist delete
---
View a user Manga listing.