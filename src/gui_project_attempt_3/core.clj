(ns gui-project-attempt-3.core
  "An attempt to port James Heliotis MVC code to Clojure.
  This code represents a counter with the ability to increment and decrement by one"
  (:require
    [gui-project-attempt-3.counter-ptui]
    [gui-project-attempt-3.counter-gui]))

(defn decider []
  "Asks the user for a GUI or PTUI"
  (println "Do you want a text interface, or a GUI?")
  (println "Type \"1\" for text, or \"2\" for GUI." )
  (flush)
  (let [input (read-line)]
    (case input
      "1" (gui-project-attempt-3.counter-ptui/-main)
      "2" (gui-project-attempt-3.counter-gui/-main)
      (println "Not a valid response, exiting"))))          ;TODO: program does not actually exit

(defn -main
  [& args]
  (decider))
