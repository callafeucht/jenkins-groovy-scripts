/***
  Script Name:  RemapJobs.groovy
  Comments:     Unmaps all jobs on instance from Master build node and re-maps to given slave label.
  Authors:      Calla Feucht
  Date Created: 05 Oct 2015
**/

import hudson.model.*
import hudson.model.labels.*
import hudson.maven.*
import hudson.tasks.*
import hudson.plugins.git.*

hudsonInstance = hudson.model.Hudson.instance
allItems = hudsonInstance.allItems
allLabels = hudsonInstance.getLabels()
slaveLabel = hudsonInstance.getLabel("SOME_LABEL_STRING_HERE")
println(slaveLabel)
println()
println(allLabels)
println()
buildableItems = allItems.findAll{ job -> job instanceof BuildableItemWithBuildWrappers }

buildableItems.each { item ->
  boolean shouldSave = false
  item.allJobs.each { job ->
	def String labelMapping=job.getAssignedLabelString()
    if (labelMapping == "master") {
      println("=============================")
      println("MASTER MAPPING")
      println(job.name)
      println(job.assignedLabel)
      println("=============================")
      job.setAssignedLabel(slaveLabel)
    }
    else if (labelMapping == null) {
      println("=============================")
      println("MASTER/NULL MAPPING")
      println(job.name)
      println(job.assignedLabel)
      println("=============================")
      job.setAssignedLabel(slaveLabel)
    }
    else {
      println("Job with name " + job.name + " does not need remapping.")
      println()
    }
  }
}
