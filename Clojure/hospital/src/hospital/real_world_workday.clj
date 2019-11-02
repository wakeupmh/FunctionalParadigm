(ns hospital.real-world-workday
  :use [clojure.pprint]
  :require [hospital.model :as h.model]
           [ hospital.business :as h.business])

(defn arrive-at [hospital person]
  (def hospital (h.business/arrive-at hospital :ticket-window person)))

(defn simulate-day []
  (let [hospital (atom (h.model/new-hospital))]
    (.start (.Thread (fn [] (arrive-at hospital "111"))))
    (.start (.Thread (fn [] (arrive-at hospital "222"))))
    (.start (.Thread (fn [] (arrive-at hospital "333"))))
    (.start (.Thread (fn [] (arrive-at hospital "444"))))
    (.start (.Thread (fn [] (arrive-at hospital "555"))))
    (.start (.Thread (fn [] (arrive-at hospital "666"))))
    (.start (.Thread (fn [] (arrive-at hospital "777"))))
    (.start (.Thread (fn [] (arrive-at hospital "888"))))
    (.start (.Thread (fn [] (Thread/sleep 4000)
                       (pprint hospital))))))