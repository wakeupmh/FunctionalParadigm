
(ns hospital.partial-and-simplify-workday
  (:use [clojure.pprint])
  (:require [hospital.business :as h.business]
            [hospital.model :as h.model]))

;side effect
(defn arrive-at! [hospital person]
      (swap! hospital h.business/arrive-at :ticket-window person))

(defn simulate-day []
      (let [hospital (atom (h.model/new-hospital))
            person ["111" "222" "333" "444" "555" "6666"]]
        (map #(.start (.Thread (fn [] (arrive-at! hospital %)))) person) ;doesn't execute anything  because map is lazy, executes only when called
        (.start (.Thread (fn [] (Thread/sleep 4000)
                           (pprint hospital))))))
(defn simulate-day []
      (let [hospital (atom (h.model/new-hospital))
            person ["111" "222" "333" "444" "555" "6666"]]
        (mapv #(.start (.Thread (fn [] (arrive-at! hospital %)))) person) ;mapv -> forces to execute
        (.start (.Thread (fn [] (Thread/sleep 4000)
                           (pprint hospital))))))
(defn simulate-day []
      (let [hospital (atom (h.model/new-hospital))
            person ["111" "222" "333" "444" "555" "6666"]]
        (map #(.start (.Thread (fn [] (arrive-at! hospital %)))) person) ;doesn't execute anything  because map is lazy, executes only when called
        (.start (.Thread (fn [] (Thread/sleep 4000)
                           (pprint hospital))))))