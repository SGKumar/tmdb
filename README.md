# tmdb
The Movie DB

## High
1. Use an existing tmdb Java sdk (or call interfaces using Netflix feign)
1. Device/use-specific customized interfaces
   1. Coarse-grained vs fine-grained APIs 
1. Single place for all entities, enums etc.,
1. Standardized request (params, input) validation
1. API key in env var
1. Standard success/failure bubbling with HTTP codes
1. Standard exception/failure management inside source
1. Use proper code tree structure
1. Pagination, deep-fetch and all query patterns


## Medium
1. Demonstrate different configs for different {dev, integ, prod} environments
1. Unit tests

## Low
1. Contract testing (assertj-swagger, pact or Spring Contracts)
1. API Documentation (Swagger ?)
1. API Version Management (GSON or otherwise ?)
1. Dockerize app

