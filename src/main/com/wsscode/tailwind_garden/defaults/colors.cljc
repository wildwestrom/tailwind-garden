(ns com.wsscode.tailwind-garden.defaults.colors
  (:require
    [com.wsscode.tailwind-garden.expanders :as exp]))

(def colors
  [["transparent" "transparent"]
   ["current" "currentColor"]
   ["black" "rgb(0, 0, 0)"]
   ["white" "rgb(255, 255, 255)"]
   ["gray-50" "rgb(249, 250, 251)"]
   ["gray-100" "rgb(243, 244, 246)"]
   ["gray-200" "rgb(229, 231, 235)"]
   ["gray-300" "rgb(209, 213, 219)"]
   ["gray-400" "rgb(156, 163, 175)"]
   ["gray-500" "rgb(107, 114, 128)"]
   ["gray-600" "rgb(75, 85, 99)"]
   ["gray-700" "rgb(55, 65, 81)"]
   ["gray-800" "rgb(31, 41, 55)"]
   ["gray-900" "rgb(17, 24, 39)"]
   ["red-50" "rgb(254, 242, 242)"]
   ["red-100" "rgb(254, 226, 226)"]
   ["red-200" "rgb(254, 202, 202)"]
   ["red-300" "rgb(252, 165, 165)"]
   ["red-400" "rgb(248, 113, 113)"]
   ["red-500" "rgb(239, 68, 68)"]
   ["red-600" "rgb(220, 38, 38)"]
   ["red-700" "rgb(185, 28, 28)"]
   ["red-800" "rgb(153, 27, 27)"]
   ["red-900" "rgb(127, 29, 29)"]
   ["yellow-50" "rgb(255, 251, 235)"]
   ["yellow-100" "rgb(254, 243, 199)"]
   ["yellow-200" "rgb(253, 230, 138)"]
   ["yellow-300" "rgb(252, 211, 77)"]
   ["yellow-400" "rgb(251, 191, 36)"]
   ["yellow-500" "rgb(245, 158, 11)"]
   ["yellow-600" "rgb(217, 119, 6)"]
   ["yellow-700" "rgb(180, 83, 9)"]
   ["yellow-800" "rgb(146, 64, 14)"]
   ["yellow-900" "rgb(120, 53, 15)"]
   ["green-50" "rgb(236, 253, 245)"]
   ["green-100" "rgb(209, 250, 229)"]
   ["green-200" "rgb(167, 243, 208)"]
   ["green-300" "rgb(110, 231, 183)"]
   ["green-400" "rgb(52, 211, 153)"]
   ["green-500" "rgb(16, 185, 129)"]
   ["green-600" "rgb(5, 150, 105)"]
   ["green-700" "rgb(4, 120, 87)"]
   ["green-800" "rgb(6, 95, 70)"]
   ["green-900" "rgb(6, 78, 59)"]
   ["blue-50" "rgb(239, 246, 255)"]
   ["blue-100" "rgb(219, 234, 254)"]
   ["blue-200" "rgb(191, 219, 254)"]
   ["blue-300" "rgb(147, 197, 253)"]
   ["blue-400" "rgb(96, 165, 250)"]
   ["blue-500" "rgb(59, 130, 246)"]
   ["blue-600" "rgb(37, 99, 235)"]
   ["blue-700" "rgb(29, 78, 216)"]
   ["blue-800" "rgb(30, 64, 175)"]
   ["blue-900" "rgb(30, 58, 138)"]
   ["indigo-50" "rgb(238, 242, 255)"]
   ["indigo-100" "rgb(224, 231, 255)"]
   ["indigo-200" "rgb(199, 210, 254)"]
   ["indigo-300" "rgb(165, 180, 252)"]
   ["indigo-400" "rgb(129, 140, 248)"]
   ["indigo-500" "rgb(99, 102, 241)"]
   ["indigo-600" "rgb(79, 70, 229)"]
   ["indigo-700" "rgb(67, 56, 202)"]
   ["indigo-800" "rgb(55, 48, 163)"]
   ["indigo-900" "rgb(49, 46, 129)"]
   ["purple-50" "rgb(245, 243, 255)"]
   ["purple-100" "rgb(237, 233, 254)"]
   ["purple-200" "rgb(221, 214, 254)"]
   ["purple-300" "rgb(196, 181, 253)"]
   ["purple-400" "rgb(167, 139, 250)"]
   ["purple-500" "rgb(139, 92, 246)"]
   ["purple-600" "rgb(124, 58, 237)"]
   ["purple-700" "rgb(109, 40, 217)"]
   ["purple-800" "rgb(91, 33, 182)"]
   ["purple-900" "rgb(76, 29, 149)"]
   ["pink-50" "rgb(253, 242, 248)"]
   ["pink-100" "rgb(252, 231, 243)"]
   ["pink-200" "rgb(251, 207, 232)"]
   ["pink-300" "rgb(249, 168, 212)"]
   ["pink-400" "rgb(244, 114, 182)"]
   ["pink-500" "rgb(236, 72, 153)"]
   ["pink-600" "rgb(219, 39, 119)"]
   ["pink-700" "rgb(190, 24, 93)"]
   ["pink-800" "rgb(157, 23, 77)"]
   ["pink-900" "rgb(131, 24, 67)"]])

(defn rgb->rgba [color alpha]
  (if-let [[_ c] (re-find #"rgb\((.+)\)" color)]
    (str "rgba(" c ", " alpha ")")
    color))

(def opacity-steps
  [["0" "0"]
   ["5" "0.05"]
   ["10" "0.1"]
   ["20" "0.2"]
   ["25" "0.25"]
   ["30" "0.3"]
   ["40" "0.4"]
   ["50" "0.5"]
   ["60" "0.6"]
   ["70" "0.7"]
   ["75" "0.75"]
   ["80" "0.8"]
   ["90" "0.9"]
   ["95" "0.95"]
   ["100" "1"]])

(defn gen-colors
  ([properties prefix]
   (exp/expand-values {::exp/properties properties
                       ::exp/prefix     prefix
                       ::exp/values     colors}))
  ([properties prefix opacity-var]
   (mapv
     (fn [[k v]]
       [(keyword (str "." prefix "-" k))
        (into {opacity-var "1"}
              (map (fn [p] [p (rgb->rgba v (str "var(" (name opacity-var) ")"))]))
              properties)])
     colors)))

(defn gen-opacity [properties prefix]
  (exp/expand-values {::exp/properties properties
                      ::exp/prefix     prefix
                      ::exp/values     opacity-steps}))
