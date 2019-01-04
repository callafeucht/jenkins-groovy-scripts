/*** BEGIN META {
  "name" : "Get plugin dependencies",
  "comment" : "Get dependencies of a single plugin.",
  "parameters" : [ 'pluginName' ],
  "authors" : [
    { name : "CloudBees Support" }
  ]
} END META**/

// NOTES:
// pluginName: the name of the plugin for which dependencies should be gathered
// Sourced from https://support.cloudbees.com/hc/en-us/articles/216351528-How-do-I-analyse-plugins-and-dependencies-for-an-instance-

pluginName = 'jobConfigHistory'

def pluginByName = jenkins.model.Jenkins.instance.getPluginManager().getPlugin(pluginName);
println "${pluginByName.getShortName()} (${pluginByName.getVersion()}) - ${pluginByName.getDependencies()}"
