$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/feature/amazon.feature");
formatter.feature({
  "line": 1,
  "name": "Amazon Search",
  "description": "",
  "id": "amazon-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Homepage",
  "description": "",
  "id": "amazon-search;homepage",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user Launch Application Url",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user click the dropdown options",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user enter the product",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "select required suggestions",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});