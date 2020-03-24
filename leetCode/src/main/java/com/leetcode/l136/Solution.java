package com.leetcode.l136;


/**
 * 
 * @author Spare_User
 *
 */

/*
这道题的标签是Bit Manipulation。所以用到是位运算。其中异或运算具有以下性质： 
0∧N=N 
N∧N=0 
异或运算符是用符号“^”表示的，其运算规律是：
两个操作数的位中，相同则结果为0，不同则结果为非0数。
https://blog.csdn.net/vebasan/article/details/6193916
 */
public class Solution {
	
	
	public int singleNumber(int[] nums) {
		int single = 0;
		for (int n : nums) {
			System.out.println("single="+single+"|n="+n);
			single ^= n;
			System.out.println("single="+single+"|n="+n);
		}
		return single;

	}
	
	//my solution
	public int singleNumber_my(int[] nums) {
		int purpos = 0;
		for(int i = 0; i<nums.length;i++) {
			purpos = nums[i];
			boolean flag = false;
			for(int j =0 ; j<nums.length;j++) {
				if (i==j) continue;
				int result = (purpos^nums[j]);
				System.out.println("result="+result+"|purpos="+purpos+"|value="+nums[j]);
				if (result == 0 ) {
					flag = false;
					break;
				}
				if (result !=0) flag = true;
			}
			if (flag) {
				return purpos;
			}
		}
		return purpos;
    }
	
	
	public static void main(String[] arg) {
		Solution execution = new Solution();
		execution.testSolution();
		System.out.println("============================");
		execution.testing();
		System.out.println("============================");
	}

	public void testSolution() {
		System.out.println("testSolution");
		//int[] i= {1,2,3,4,5,67,67,1,2,3,4,5,6,6,1,7};
		int[] i= {1,3,1,-1,3};
		//int[] i= {1042,40,976,347,672,-64,221,756,866,182,943,-336,-36,467,891,1183,-432,1014,812,-211,174,382,-180,-136,-88,903,1177,869,-305,640,-201,-223,960,-271,800,-8,146,1074,-429,-186,-312,491,485,389,-276,-369,835,1007,818,-548,373,1028,71,176,-272,487,485,961,211,16,-345,779,1121,45,-366,-577,607,-238,504,-489,-354,-574,468,914,292,403,606,262,-536,-225,-508,-392,256,330,6,-491,775,101,881,887,433,72,474,594,-366,733,-119,283,453,-103,703,-281,-491,-331,-367,1074,849,-488,-516,902,-541,-457,1041,-445,1032,772,-457,418,1041,741,-471,679,-122,901,1120,-452,670,765,712,-575,1066,511,321,709,-553,26,-541,369,1039,487,1188,825,-224,1009,-557,891,243,956,434,-500,982,306,-85,475,-426,243,-323,410,576,800,345,264,103,812,444,490,955,659,262,462,-37,-227,388,1111,-335,6,-305,-338,-212,-276,899,1116,1138,-489,672,444,584,-105,361,-271,-277,-562,1128,682,388,929,907,983,663,994,-8,1040,149,1114,-47,-414,1055,799,-5,532,387,111,1162,-351,275,824,137,8,30,722,-207,-335,882,268,336,1065,-552,-556,940,764,-76,869,32,72,386,-126,-484,866,-296,258,1114,71,747,165,563,675,-287,818,216,947,1137,-203,635,881,964,508,635,1093,77,298,-35,221,130,165,-498,930,284,983,65,160,-447,-119,-498,-31,-493,-363,-442,-233,1016,-232,-309,1192,418,1065,-177,753,1038,-273,-107,1103,1038,-429,229,1124,-40,85,-20,-38,875,7,-373,592,827,513,307,-479,538,840,-570,326,-130,1016,32,-481,-459,-63,714,723,33,-94,45,-409,932,-496,-386,747,529,-259,1025,-571,1190,421,-493,988,406,337,115,1033,889,273,102,387,254,735,-172,473,595,488,-267,-234,-39,533,933,950,29,640,9,-223,779,329,324,773,176,1141,-598,259,-523,-397,887,1057,568,-20,-143,729,529,-92,-250,-519,38,840,84,46,731,281,988,-165,503,-479,203,1159,-577,369,-414,472,166,763,495,332,650,537,814,-561,1051,305,896,1099,-254,-251,412,512,1033,805,114,4,1024,-143,157,-149,576,156,-531,653,548,890,229,965,130,588,195,-107,-543,513,-370,964,48,490,314,617,-31,1145,225,326,740,940,-492,-180,437,-39,-561,458,101,264,1060,692,382,-52,-311,592,-120,1103,-468,1154,603,155,410,164,35,-481,526,568,195,415,549,258,-232,-592,156,184,658,767,1057,-569,508,-501,-598,902,361,-96,1055,1003,163,1109,-447,1099,439,-156,1173,-543,-106,-252,1013,1158,773,712,-36,1039,359,963,-473,1142,397,-484,-191,903,848,1137,378,-453,914,1145,1192,883,-326,1066,164,-35,259,-455,9,772,1191,-231,951,184,831,85,587,-398,4,-486,-27,-55,307,-285,-267,-146,782,390,275,-270,-40,824,140,607,787,-174,66,186,-571,-197,256,-250,96,397,-197,731,257,733,462,1030,191,1014,-96,-201,-369,976,-34,304,463,669,-186,-98,1120,-62,466,550,1025,114,-121,-307,594,-544,333,814,406,-487,822,1019,-301,96,-219,343,-86,-254,157,35,-539,738,1036,965,-34,-452,-336,333,1164,748,115,882,1042,-308,-209,212,-114,-37,578,-307,463,538,763,1081,1153,-311,-526,-301,16,1183,930,523,-103,1036,-592,954,332,152,760,581,1116,-386,-492,140,-467,329,1142,1121,-263,532,898,968,961,-309,149,263,1022,-323,55,-508,1012,937,-572,472,-562,-252,1002,835,1154,292,-391,805,714,-259,-531,84,-312,310,227,-83,890,-62,34,886,603,528,-281,-209,-553,-165,511,-155,-146,1063,-570,998,-122,372,735,755,848,767,191,146,-212,-92,587,626,1128,93,512,756,323,158,-114,-391,-236,-150,227,765,-349,748,1007,-185,617,-253,-27,174,1161,-155,111,499,-371,1002,533,899,-501,829,24,-283,951,-424,799,-373,1134,503,24,59,-471,-459,1076,787,-270,-38,994,372,-159,-231,251,-69,1076,659,271,306,963,75,403,-433,155,-278,38,491,474,7,898,427,-104,-272,-441,341,889,169,-236,330,556,-397,650,30,-320,1093,323,212,494,355,461,790,-285,1030,389,-321,606,1190,855,94,-121,1197,-98,160,-320,-511,1159,-534,819,26,296,584,-392,251,284,-534,-32,-55,295,408,563,328,-132,102,1049,498,-308,950,-132,93,-345,-559,50,139,336,829,-144,-172,790,542,281,422,-340,803,445,-519,-496,-327,-28,-338,-227,775,-156,-238,-159,-88,203,-360,537,-520,741,878,1040,17,819,526,738,1173,-3,467,355,59,753,548,-225,1177,692,722,74,-203,163,1101,-574,399,1028,337,595,-445,1158,-453,2,473,760,-104,-105,133,878,1019,-94,1095,-536,956,158,960,-218,883,-523,328,-218,425,-470,-126,1111,875,-441,-363,126,827,-331,65,398,-334,1132,504,968,125,-412,339,1162,1124,468,453,755,982,-548,908,1060,-64,488,-63,-412,-334,-468,186,1191,-349,523,846,-144,182,398,310,1013,75,437,-47,-85,556,137,-539,211,825,939,803,445,768,494,-354,849,46,-556,770,304,-4,929,495,901,1176,-360,-455,-544,-486,770,-421,347,-327,1141,658,-433,-557,-473,542,152,34,-321,886,499,723,1095,1081,345,663,831,263,341,1024,682,939,139,257,550,125,855,-69,475,-211,-251,17,-287,-5,498,1022,-86,1051,-470,907,-149,-351,305,675,298,412,653,-575,578,-28,740,439,373,-54,166,768,1009,-185,254,-150,-370,-569,399,314,55,225,-224,-516,335,-326,729,133,-177,-559,126,527,1032,549,359,703,-54,-32,-191,433,1109,1101,19,581,626,-278,296,527,1049,-283,-3,335,-487,74,386,954,1063,458,343,-277,679,1161,782,-488,-552,-424,846,-207,466,932,-4,321,-526,19,1134,588,558,378,421,-174,-263,-120,-367,822,1003,-572,48,-296,528,422,-421,66,908,764,77,50,998,-409,-398,-432,1188,40,-234,-130,295,-106,1012,-233,461,-467,943,1197,-520,273,1153,425,-182,-76,2,-273,390,947,-340,94,216,283,271,-426,-371,937,169,8,-83,268,-511,408,709,-182,103,339,427,434,955,896,669,-136,29,33,1164,670,558,1132,-500,415,-52,933,324,1176,-442,1138,-253};
		int result = singleNumber(i);
		System.out.println("result="+result);
	}
	
	public void testing() {
		System.out.println("testing");
		int i = 1^2;
		System.out.println("0^0="+(0^0));
		System.out.println("1^2="+i);
		System.out.println("2^2="+(2^2));
		System.out.println("-1^1="+(-1^1));
		System.out.println("-1^-3="+(-1^-3));
		System.out.println("2^5="+(2^5));
		System.out.println("88^88="+(88^88));
		System.out.println("88^80="+(88^80));
		int j8=8; 
		int k8=8;
		int l9=9;
		int s = (k8^j8);
		System.out.println("k8^j8="+s);
		System.out.println("k8^l9="+(k8^l9));
	}
}