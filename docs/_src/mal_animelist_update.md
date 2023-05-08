---
command: mal animelist update <id>
options:
  - flags: [-S, --status]
    type: string
    desc: |
      The list status

      |status|
      |---|
      |`watching`|
      |`completed`|
      |`on_hold`|
      |`dropped`|
      |`plan_to_watch`|
  - flags: [-R, --rewatching]
    type: boolean
    desc: If rewatching
  - flags: [-s, --score]
    type: integer
    desc: Listing score
  - flags: [-e, --episodes]
    type: integer
    desc: The number of watched episodes
  - flags: [-p, --priority]
    type: integer
    desc: The priority
  - flags: [-r, --rewatched]
    type: integer
    desc: The number of times rewatched
  - flags: [-v, --rewatch-value]
    type: integer
    desc: The rewatch value
  - flags: [-t, --tag]
    type: string
    desc: The tags
  - flags: [-c, --comment]
    type: string
    desc: The comments
  - yes
  - csv
  - json
  - jq
see-also:
  - mal animelist view
  - mal animelist delete
---