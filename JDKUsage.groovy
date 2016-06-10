/***
	Script Name:	JDKUsage.groovy
	Comments:		Pulls JDK setting from each buildable item on Jenkins instance.
	Authors:		Calla Feucht
	Date Created:	14 July 2015
**/

import hudson.model.*

for(item in Hudson.instance.items) {
	println(item.name)
	try {
		jdk = item.getJDK()
		if(jdk != null) {
			try {
				println(jdk.defaultValue)
			}
			catch(Exception e) {
				println(jdk.name)
			}
			}
		else {
			println("(Default)")
		}
	}
	catch(Exception e) {
		println()
	}
}
