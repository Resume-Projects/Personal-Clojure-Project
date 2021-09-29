(ns gui-project-attempt-3.counter-gui
  " A gui to control a counter.
  This contains both the view and the controller
  @author rl2939@g.rit.edu"
  (:require
    [gui-project-attempt-3.counter]
            [cljfx.api :as fx]))

(def *state
  "Stores the number for the gui"
  (atom {:number (str @gui-project-attempt-3.counter/counter)}))

(defn root [{:keys [number]}]
  {:fx/type :stage
   :showing true
   :title   "COUNTER"
   :scene   {:fx/type :scene
             :root    {:fx/type     :stack-pane
                       :pref-width  250
                       :pref-height 20
                       :children    [{:fx/type              :button
                                      :stack-pane/alignment :center-left
                                      :stack-pane/margin    5
                                      :text                 "-"
                                      :on-action            {:event/type ::subtracter}
                                      }
                                     {:fx/type              :button
                                      :stack-pane/alignment :center-right
                                      :stack-pane/margin    5
                                      :text                 "+"
                                      :on-action            {:event/type ::adder}
                                      }
                                     {:fx/type              :label
                                      :stack-pane/alignment :center
                                      :stack-pane/margin    5
                                      :text                 number
                                      }]}}})

(defn map-event-handler [event]
  (case (:event/type event)
    ::adder      (gui-project-attempt-3.counter/adder)
    ::subtracter (gui-project-attempt-3.counter/subtracter)
    nil)
  (swap! *state assoc :number (str @gui-project-attempt-3.counter/counter)))

(defn -main []
  (fx/mount-renderer
  *state
  (fx/create-renderer
    :middleware (fx/wrap-map-desc assoc :fx/type root)
    :opts {:fx.opt/map-event-handler map-event-handler})))