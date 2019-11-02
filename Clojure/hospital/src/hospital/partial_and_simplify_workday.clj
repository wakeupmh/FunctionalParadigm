
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
(defn simulate-day-mapv []
      (let [hospital (atom (h.model/new-hospital))
            person ["111" "222" "333" "444" "555" "6666"]]
        (mapv #(.start (.Thread (fn [] (arrive-at! hospital %)))) person) ;mapv -> forces to execute
        (.start (.Thread (fn [] (Thread/sleep 4000)
                           (pprint hospital))))))


(defn simulate-day-refactored []
      (let [hospital (atom (h.model/new-hospital))
            person ["111" "222" "333" "444" "555" "6666"]
            start-thread #(.start (.Thread (fn [] (arrive-at! hospital %))))]
        (map start-thread person)
        (.start (.Thread (fn [] (Thread/sleep 4000)
                           (pprint hospital))))))

(defn start-thread
      ([hospital]
       (fn [person] (start-thread hospital) person))
      ([hospital person]
       (.start (.Thread (fn [] (arrive-at! hospital person))))))

(defn simulate-day-clean-code[]
      (let [hospital (atom (h.model/new-hospital))
            person ["111" "222" "333" "444" "555" "6666"]
            start (start-thread hospital)]
        (map start person)
        (.start (.Thread (fn [] (Thread/sleep 4000)
                           (pprint hospital))))))


(defn start-thread
      [hospital person]
       (.start (.Thread (fn [] (arrive-at! hospital person)))))

(defn simulate-day-partial[]
      (let [hospital (atom (h.model/new-hospital))
            person ["111" "222" "333" "444" "555" "6666"]
            start (partial start-thread hospital)]
        (map start person)
        (.start (.Thread (fn [] (Thread/sleep 4000)
                           (pprint hospital))))))

(defn start-thread
      [hospital person]
      (.start (.Thread (fn [] (arrive-at! hospital person)))))
;if you see a doseq presumed it's a side effect
(defn simulate-day-with-do-seq[]
      (let [hospital (atom (h.model/new-hospital))
            persons ["111" "222" "333" "444" "555" "6666"]]
        (doseq [person persons] (start-thread hospital person))      ;looks like an for inside a for, but performed
        (.start (.Thread (fn [] (Thread/sleep 4000)
                           (pprint hospital))))))