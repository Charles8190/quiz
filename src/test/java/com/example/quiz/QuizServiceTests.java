package com.example.quiz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.quiz.constants.OptionType;
import com.example.quiz.service.itfs.QuizService;
import com.example.quiz.vo.BasicRes;
import com.example.quiz.vo.CreateOrUpdateReq;
import com.example.quiz.vo.Question;

//@SpringBootTest
public class QuizServiceTests {

	@Autowired
	private QuizService quizService;

	@Test
	public void createTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "健康餐?", "松阪豬;炸豬排;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "丹丹", "1號餐;2號餐;3號餐;4號餐松阪豬;炸豬排;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "炒飯?", "豬肉炒飯;海鮮炒飯;干貝馬鈴薯(推);綜合炒飯", //
				OptionType.SINGLE_CHOICE.getType(), true));
		CreateOrUpdateReq req = new CreateOrUpdateReq(0, "午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
		// 刪除測試資料 TODO

	}

	@Test
	public void createNameErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "健康餐?", "松阪豬;炸豬排;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "丹丹", "1號餐;2號餐;3號餐;4號餐松阪豬;炸豬排;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "炒飯?", "豬肉炒飯;海鮮炒飯;干貝馬鈴薯(推);綜合炒飯", //
				OptionType.SINGLE_CHOICE.getType(), true));
		CreateOrUpdateReq req = new CreateOrUpdateReq(0, "", "午餐吃啥?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");

	}

	@Test
	public void createStartDateErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "健康餐?", "松阪豬;炸豬排;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "丹丹", "1號餐;2號餐;3號餐;4號餐松阪豬;炸豬排;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "炒飯?", "豬肉炒飯;海鮮炒飯;干貝馬鈴薯(推);綜合炒飯", //
				OptionType.SINGLE_CHOICE.getType(), true));
		// 今天是 2024/5/30，所以開始日期不能是當天或是之前
		CreateOrUpdateReq req = new CreateOrUpdateReq(0, "午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 5, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");

	}

	@Test
	public void createTest1() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "健康餐?", "松阪豬;炸豬排;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		// 測試 name error
		CreateOrUpdateReq req = new CreateOrUpdateReq(0, "", "午餐吃啥?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");
		// 測試 start date error: 假設今天是 2024/5/30，所以開始日期不能是當天或是之前
		req = new CreateOrUpdateReq(0, "午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 5, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");
		// 測試 end date error: 結束日期不能比開始日期早
		req = new CreateOrUpdateReq(0, "午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 5, 30), questionList, true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param end date error!!"), "create test false!!");
		// 剩餘的邏輯全部判斷完之後，最後才會是測試成功的情境
		req = new CreateOrUpdateReq(0, "午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
	}

	@Test
	public void sumTest() {
		List<String> list = List.of("紅茶", "綠茶", "烏龍", "紅茶", "清茶", "紅茶", "紅茶", "紅茶");
//		resultList = input_string.split(';');
		String target = "紅茶";
		int sum = 1;
		List<String> indexList = new ArrayList<>();
		// 方法1
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) == list.get(j)) {
					indexList.add(list.get(i));
					sum = sum + 1;
				}
			}

		}
		System.out.println(indexList);
		System.out.println(sum);
	}

	@Test
	public void test9() {
		List<String> list = List.of("紅茶", "綠茶", "烏龍", "紅茶", "清茶", "紅茶", "紅茶", "紅茶");
		String str = "神鵰俠侶";
		// 用空字串去切，會切割每個字: [神, 鵰, 俠, 侶]
		String[] newStr = str.split("");
		// 用空字串去切，會切割每個字: [神, 俠侶]
		String[] newStr2 = str.split("鵰");
		for (String item : list) {
			System.out.println(item);
		}
		// newStr2 = 神_鵰_俠_侶
		// join: 用於將字串的陣列/集合串成新字串
//		String newStr3 = String.join("_", newStr);
//		System.out.println(newStr3);
	}

	@Test
	public void hw3() {
		List<String> list = List.of("A", "B", "C", "D", "E");
		String str = "AABCBDCDACBDA";

		Map<String, Integer> map = new HashMap<>();
		for (String item : list) {
			String newStr = str.replace(item, "");
			System.out.println("str = " + str);
			System.out.println("newStr = " + newStr);
			int count = str.length() - newStr.length();
			map.put(item, count);

		}
		System.out.println(map);

	}
}
