(ns gui-project-attempt-3.counter-ptui
  "A plain-text user Interface (PTUI) to control a counter
  This function is both the view and controller
  @author rl2939@g.rit.edu"
  (:require [gui-project-attempt-3.counter]))

(def repeater (atom true))

(defn error [message, critical]
  (println message)                                         ;NEVER do this with a GUI!
  (if (true? critical)
    ((println message)(System/exit 1))))


(defn the-thread-mini
  []
  (future
    (while (deref repeater)
      (print "cmd> ")
      (flush)
      (let [input (read-line)]
        (case input
          "+" (println "Value is" (gui-project-attempt-3.counter/adder) )
          "-" (println "Value is" (gui-project-attempt-3.counter/subtracter))
          "." (reset! repeater false)                       ;there is no "break" statement in Clojure.
          (error "illegal command", false))))
    (println "exiting")
    (shutdown-agents)))


(defn -main
  [& args]
  (deref (the-thread-mini)))

