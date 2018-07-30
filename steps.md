# Writing a moviedb service - Best practices

## Assumptions
* For now, end-users will use the API key available with this REST service (no authn)

## Use-cases
### Users should be able to:

1. get movie details
1. list movies 
1. filter movies only by genre, year, actors
1. update movies: for now just rating
1. Given movie -> find actors.
1. list actors
1. Given actor -> find movies.

## End-points
1. GET /api/movies/$movieId
1. GET /api/movies/
1. PUT /api/movies/$movieId
1. GET /api/movies/$movieId/actors
1. GET /api/actors
1. GET /api/actors/$actorId/movies

## Defensive 
1. Request params validation
1. Standardized errors
1. Pagination
1. Deep fetch

## Hygiene-factors
1. Different configs for different {dev, integ, prod} environments
1. Unit tests (mock ?)
1. 
1. Contract testing (assertj-swagger, pact or Spring Contracts)
1. API Documentation (Swagger ?)
1. API Version Management (GSON or otherwise ?)

## NFRs
1. Health-check endpoint
1. Dockerize app
