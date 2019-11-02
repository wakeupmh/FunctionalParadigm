(ns hospital.workday2
  :use
  [clojure.pprint]
  :require
  [hospital.business :as h.business]
  [hospital.model :as h.model]
  (:require [hospital.model :as h.model]))

(defn big-atom []
  (let [hospital-lima (atom {:wait h.model/empty-queue})]

    ))
