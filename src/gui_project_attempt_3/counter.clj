(ns gui-project-attempt-3.counter
  "A namespace that maintains an integer counter and can be observed by a UI.
  It represents the model in the MVC architectural patten
  @author rl2939@g.rit.edu")

(defn modifier [k r o n]
  ;; Takes a function key, reference, old value and new value
  n)

(def counter (ref 0))

(add-watch counter :count-watcher modifier)

(defn adder []
  (dosync (alter counter inc)))

(defn subtracter []
  (dosync (alter counter dec)))