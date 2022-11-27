# Asteroids Near Earth

Shows asteroids that have had close approaches to Earth for a given week.
Data source: NASA NeoWS (Near Earth Object Web Service) - https://api.nasa.gov 

## Getting started

### Prerequisites
To run these applications locally, you need Java and Maven installed for backend, and Yarn / Npm and Node installed for frontend: 

````shell
# Install Homebrew:
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
# Install SDK Man
brew install sdkman
# Install Java:
sdk install java 11.0.16-zulu  
# Install Maven
sdk install maven
# Install Yarn:
brew install yarn
# Install Node:
brew install node
````

### Cloning the repo

```shell
# Clone the repository
git clone https://github.com/solveigmarianes/asteroids.git

# Navigate into the directory:
cd asteroids
```

### Backend
````shell
# Navigate into the backend app directory: 
cd asteroids-backend

# Install and run the application:
mvn clean install spring-boot:run
````

The app should now be running on [http://localhost:8080](http://localhost:8080)

### Frontend
````shell
# Navigate into the frontend app directory
cd ../asteroids-frontend 

# Install dependencies: 
yarn

# Run the application in development mode:
yarn start
````

The app should now be running on [http://localhost:3000](http://localhost:3000)


## Endpoints
### GET `/api/asteroids`
Get all asteroids that has a close approach to Earth from the date specified and one week forward.

Required query param: `startDate`, format: `YYYY-MM-DD`

Example request: [http://localhost:8080/api/asteroids?startDate=2015-08-09](http://localhost:8080/api/asteroids?startDate=2015-08-09)

### GET `/api/asteroids/{id}`

Get asteroid by ID.

Path param `id`, format: `ddddddd`

Example request: [http://localhost:8080/api/asteroids/2465633](http://localhost:8080/api/asteroids/2465633)

## Thoughts on future improvements

### General
- Write tests
- But both apps into a Docker container, so it's easier to run
 
### Backend:
- Add Swagger docs for endpoints
- Create DTOs that are better suited to the frontend consumers' usage.
- Improve caching: Should cache one entry per date, instead of one entry per period when caching collections.

### Frontend:
- Add icons to improve intuitiveness. Display icons instead of 'Yes' and 'No' values.
- Improve accessibility so that HTML markup is semantically precise.
- Asteroid Detail page: More information - Display orbital data. Add graphics to visualize size, orbit, trajectory etc.
- Better null-checking for possibly empty JSON objects