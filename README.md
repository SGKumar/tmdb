# tmdb
The Movie DB

## High
- [x] Use proper code tree structure
- [x] API key in env var
- [x] Use an existing tmdb Java sdk (or call interfaces using Netflix feign)
- [ ] Device/use-specific customized interfaces
   - [ ] Coarse-grained vs fine-grained APIs 
- [ ] Single place for all entities, enums etc.,
- [ ] Standardized request (params, input) validation
- [ ] Standard success/failure bubbling with HTTP codes
- [ ] Standard exception/failure management inside source
- [ ] Pagination, deep-fetch and all query patterns


## Medium
- [x] Demonstrate different configs for different {dev, integ, prod} environments
- [x] Unit tests

## Low
- [x] Contract testing (assertj-swagger, pact or Spring Contracts)
- [] API Documentation (Swagger ?)
- [] API Version Management (GSON or otherwise ?)
- [] Dockerize app

