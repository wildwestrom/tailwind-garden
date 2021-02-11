(ns com.wsscode.tailwind-garden.defaults.layout
  (:require
    [com.wsscode.tailwind-garden.expanders :as exp]))

(def positions
  [["0" "0px"]
   ["0.5" "0.125rem"]
   ["1" "0.25rem"]
   ["1.5" "0.375rem"]
   ["2" "0.5rem"]
   ["2.5" "0.625rem"]
   ["3" "0.75rem"]
   ["3.5" "0.875rem"]
   ["4" "1rem"]
   ["5" "1.25rem"]
   ["6" "1.5rem"]
   ["7" "1.75rem"]
   ["8" "2rem"]
   ["9" "2.25rem"]
   ["10" "2.5rem"]
   ["11" "2.75rem"]
   ["12" "3rem"]
   ["14" "3.5rem"]
   ["16" "4rem"]
   ["20" "5rem"]
   ["24" "6rem"]
   ["28" "7rem"]
   ["32" "8rem"]
   ["36" "9rem"]
   ["40" "10rem"]
   ["44" "11rem"]
   ["48" "12rem"]
   ["52" "13rem"]
   ["56" "14rem"]
   ["60" "15rem"]
   ["64" "16rem"]
   ["72" "18rem"]
   ["80" "20rem"]
   ["96" "24rem"]
   ["auto" "auto"]
   ["px" "1px"]
   ["1/2" "50%"]
   ["1/3" "33.333333%"]
   ["2/3" "66.666667%"]
   ["1/4" "25%"]
   ["2/4" "50%"]
   ["3/4" "75%"]
   ["full" "100%"]])

(defn gen-positions [properties prefix]
  (exp/expand-values
    {::exp/properties properties
     ::exp/prefix     prefix
     ::exp/values     positions}))

(defn gen-positions+negatives [properties prefix]
  (exp/expand-values+negatives
    {::exp/properties properties
     ::exp/prefix     prefix
     ::exp/values     positions}))
