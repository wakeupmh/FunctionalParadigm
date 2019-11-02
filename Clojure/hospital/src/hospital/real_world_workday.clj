(ns hospital.real-world-workday
  (:use [clojure.pprint])
  (:require [hospital.business :as h.business]
            [hospital.model :as h.model]))

;side effect
(defn arrive-at! [hospital person]
      (swap! hospital h.business/arrive-at :ticket-window person))
;swap! -> works like transaction, if can't execute, retry again
;We can set limits on these transactions by indicating to swap! that executes the entire content of the function only once with input and output results, as if it were an atom.
; If in the middle of this process any data breaks, the program retries.
;With that, we no longer have to worry about locking

(defn simulate-day []
  (let [hospital (atom (h.model/new-hospital))]
    (.start (.Thread (fn [] (arrive-at! hospital "111"))))
    (.start (.Thread (fn [] (arrive-at! hospital "222"))))
    (.start (.Thread (fn [] (arrive-at! hospital "333"))))
    (.start (.Thread (fn [] (arrive-at! hospital "444"))))
    (.start (.Thread (fn [] (arrive-at! hospital "555"))))
    (.start (.Thread (fn [] (arrive-at! hospital "666"))))
    (.start (.Thread (fn [] (arrive-at! hospital "777"))))
    (.start (.Thread (fn [] (arrive-at! hospital "888"))))
    (.start (.Thread (fn [] (Thread/sleep 4000)
                       (pprint hospital))))))