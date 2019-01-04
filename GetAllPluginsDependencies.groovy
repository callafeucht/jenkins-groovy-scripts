/*** BEGIN META {
  "name" : "Get all plugins dependencies",
  "comment" : "List installed plugins and the dependencies of those plugins.",
  "authors" : [
    { name : "CloudBees Support" }
  ]
} END META**/

// Sourced from https://support.cloudbees.com/hc/en-us/articles/216351528-How-do-I-analyse-plugins-and-dependencies-for-an-instance-

def plugins = jenkins.model.Jenkins.instance.getPluginManager().getPlugins()
plugins.each {
    println "${it.getShortName()} (${it.getVersion()}) - ${it.getDependencies()}"
}
