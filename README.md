# Credit Rating Data Bureau

The intention of this project is to display an architecture sample for a Credit Rating
Data Bureau based on three databases with orchestrated micro-services and nano-services;

## Data Bureau Architecture

![Whole Architechture Model](https://i.imgur.com/8i4FtRf.png)

## Container Services Achitecture

![Services Architechture Model](https://i.imgur.com/mLl5KVR.png)

## Virtual Private Cloud

All of our services, databases and choreography between applications will be running on a virtual private cloud (AWS VPC)
encapsulating some services access, except for our front-end that will be available through 453 port, and specially
securing our databases just for applications inside this subnet.

## Front End

README.md available at https://github.com/rkoszalka/data-bureau-frontend

Our front-end will be based on ReactJS and running at one EC2 instance available at any time.
There are a few things that I would like to point out here:

- If this were a production application it would be based on an EKS or EBS cluster with load balancer;
- But just for a showcase purpose, with no need of high availability, I chose to use a simple EC2 instance.

If we had a dedicated DNS or IP we could host our front end in an S3 bucket instead.

## Databases

- Amazon RDS Oracle;
- Amazon Aurora Machine Learning;
- Apache Cassandra for quick data access;

##### Amazon RDS Oracle

This will be our PII database, the choice were made upon some Oracles known 
features like its reliability, security and most of all because of Data Readaction to
mask PII data with security, even for developers with database access;

##### Amazon Aurora Machine Learning

The choice for our second database, Aurora ML with PostgreSQL compatibility
were made upon two premises:
- The need for data extraction based on machine learning;
- its data masking capacities for sensible data;

(for this
showcase purpose I chose to use a Provisioned Capacity type, but if it were for a production
database it should be a Serverless database for its workload adjustment capacities);

#### Amazon Cassandra or Amazon Redshift

For our third database we could consider a columnar database like Redshift:

 - Redshift capacity for fast aggregations, such as aggregating CPF data like: last
search, credit card transactions associated with specified address and also financial movement aggregated with that same
  CPF.
   
Or a key-value database like Cassandra: 
- Apache Cassandra, cheaper price, with a very quick query performance, but because of its key-value aspect, not so much
as Redshift, with its aggregation mechanism would be.
  
Upon this two options, I chose to use Cassandra for its better cost / benefices balance
since it is just a bureau showcase and not a huge application in production.

## Micro-Service

Our most important microservice will work as an orchestrator to all of our nano-services and host of our CI/CD tools:
- All of our REST call; 
- Endpoint security 
- Event Producers 
- Host our CI tools, Jenkins and Docker (for production this would not be recommended but for showcase purposes
we can share the same EC2 instance for both purposes).

## Nano-Services

- Docker containers acting like nano-services will be our "work horse";
- We could also be using lambdas functions because of its high availability, great computing
performance and also with a "serverless" architecture. But since it is just a showcase, I chose to be using simple
  Docker containers instead in a single EC2 instance, also to be cheaper to maintain;
- Another thing is that the lambda functions should have a super fast startup time to avoid prejudice the application
runtime TTL;
- If this were a production application I could write those functions with Quarkus, Python or even NodeJS, that could
have the minimum startup time required. But since its just a showcase I decided to keep everything written in Spring Boot
  because of its fast development time, and my knowledge of this framework;
  
## Continuous Integration

###### Few considerations
- Jenkins Job available at: http://ec2-34-234-172-15.compute-1.amazonaws.com:8080/job/data-bureau/
- It is not running on TLS because we do not have a top level domain to issue a ssl certificate;
- For user/password just send me a message or email (information available on my GitHub profile);

###### Jenkinsfile

I wrote the Jenkinsfile based upon a multi module project, this is just to keep all the backend code available
at one repository, they will be dockerized and run as a nano-service running on a specific port.

If the system were designed for production and if a better implementation flow 
were necessaryI would create one repository for each nano-service and also one Jenkins job for each one of them.

## Tests

Based upon http://openmymind.net/2011/2/23/Foundations-of-Programming-2-Chapter-5-Effective-T