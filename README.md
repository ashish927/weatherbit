Allows users to view temperatures for various countries and zip/pin/area codes.

Support filtering of hottest/coldest days

APIs
1. weather/{countryCode}/{zipCode}?tempOption?"xx"
	where tempOption is either "hottest" or "coolest" while the default is set to "coolest"

Weather records are sorted and filtered for days after tomorrow by default for now.