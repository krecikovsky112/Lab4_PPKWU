# API

REST API to convert data from format XML, JSON, TXT, CSV to format XML, JSON, TXT, CSV.

## Usage

To use API you must send GET request to selected endpoint(providing the input and output format, as well as the string of characters about which we want to receive information).
#### Syntax
````
path_to_API/{input format}/{output format}/{text}
````

## Examples:

#### TXT -> CSV

Request:
````
http://localhost:8082/string_utility_controller/csv/csv/TEST%2012%20Sassa
````
Response:
````
uppercase,lowercase,numbers,specialCharacters,whitespaces
 5, 4, 2, 4, 2
 ````
#### JSON -> XML
 
Request:
````
http://localhost:8082/string_utility_controller/json/xml/TEST%2012%20Sassa
 ````
Response:
````
<stats>
<uppercase>5</uppercase>
<lowercase>4</lowercase>
<numbers>2</numbers>
<specialCharacters>4</specialCharacters>
<whitespaces>2</whitespaces>
</stats>
````
#### XML -> JSON
 
Request:
````
http://localhost:8082/string_utility_controller/xml/json/TEST%2012%20Sassa
````
Response:
````
{"uppercase":5,"lowercase":4,"numbers":2,"specialCharacters":4,"whitespaces":2}
````
#### CSV -> TXT
   
Request:
````
http://localhost:8082/string_utility_controller/csv/txt/TEST%2012%20Sassa
````
Response:
````
   lowerCase: 4
   upperCase: 5
   whitespaces: 2
   numbers: 2
   specialCharacters: 4
````
# API to conversion archival data
REST API to convert archival data from format XML, JSON, TXT, CSV to format XML, JSON, TXT, CSV.

## Usage

To use the API, send a GET request with data in the input and output format of the sequence given
characters:
#### Syntax
````
path_to_API/{input format}/{output format}/{text}
````
## Examples
#### TXT -> JSON

Request:
````
http://localhost:8082/string_utility_controller_archival/txt/json/lowerCase:4%20upperCase:5%20whitespaces:2%20numbers:2%20specialCharacters:4
````
Response:
````
{"upperCase":"5","lowerCase":"4","numbers":"2","specialCharacters":"","whitespaces":"2"}
````