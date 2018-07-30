# Writing a moviedb service - Best practices

## Assumptions
* For now, end-users will use the API key available with this REST service (no authn)

## Use-cases
### Users should be able to:

- [ ] get movie details
- [ ] list movies 
- [ ] filter movies only by genre, year, actors
- [ ] update movies: for now just rating
- [ ] Given movie -> find actors.
- [ ] list actors
- [ ] Given actor -> find movies.

## End-points
- [] GET /api/movies/$movieId
- [] GET /api/movies/
- [] PUT /api/movies/$movieId
- [] GET /api/movies/$movieId/actors
- [] GET /api/actors
- [] GET /api/actors/$actorId/movies

## Defensive 
- [] Request params validation
- [] Standardized errors
- [] Pagination
- [] Deep fetch

## Hygiene-factors
- [] Different configs for different {dev, integ, prod} environments
- [] Unit tests (mock ?)
- [] 
- [] Contract testing (assertj-swagger, pact or Spring Contracts)
- [] API Documentation (Swagger ?)
- [] API Version Management (GSON or otherwise ?)

## NFRs
- [x] Health-check endpoint
- [] Dockerize app
