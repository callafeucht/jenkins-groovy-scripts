/***
	Script Name:	MonthlyBuildCount.groovy
	Comments:		Provides per-job build count for the last month as well as total build count.
					Update the startDate and endDate values as appropriate.
	Authors:		Calla Feucht
	Date Created:	06 Jan 2016
**/

jenkins = Jenkins.getInstance()
int totalNum = 0
// UPDATE THESE DATES				     v v v v v
startDate = new Date().parse('yyyy-MM-dd HH:mm:ss', '2015-12-01 00:00:00')
endDate = new Date().parse('yyyy-MM-dd HH:mm:ss', '2015-12-31 23:59:59')
// UPDATE THESE DATES 				   ^ ^ ^ ^ ^
long startTime = startDate.getTime();
long endTime = endDate.getTime();
allItems = jenkins.allItems
allJobs = allItems.findAll{ job -> job instanceof BuildableItemWithBuildWrappers }
allJobs.each() { job ->
  println ("Job name: " + job.name)
  runs = job.builds.byTimestamp(startTime, endTime).size()
  println ("Builds this month: " + runs)
  totalNum = totalNum + runs
  println ("Total runs so far: " + totalNum)
  println()
}
println ("TOTAL NUMBER OF RUNS: " + totalNum)
